package com.bedbath.springbatchexercise2.config;

import com.bedbath.springbatchexercise2.model.Taxonomy;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.retry.annotation.Retryable;

@Configuration
@EnableBatchProcessing
//@EnableRetry
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Value("sample-data.csv")
    private FileSystemResource inputCsv;

    @Bean
    public Job readCSVFilesJob() {
        return jobBuilderFactory
                .get("readCSVFilesJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<Taxonomy, Taxonomy>chunk(15)
                .reader(reader())
                .writer(writer())
                .processor(csvTaxonomyProcessor())
                .faultTolerant()
                .retryLimit(2)
                .retry(ItemStreamException.class)
                .build();
    }

    @Bean
    public FlatFileItemReader<Taxonomy> reader() {
        //Create reader instance
        int counter = 0;
        FlatFileItemReader<Taxonomy> reader = new FlatFileItemReader<Taxonomy>();
        reader.setLinesToSkip(1);

        //Configure how each line will be parsed and mapped to different values
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter("|");
        String[] tokens = {"CHILD_CAT_ID", "CATEGORY_ID", "DISPLAY_NAME", "IS_COLLEGE", "NODE_TYPE", "PHANTOM_CATEGORY", "GUIDE_ID", "SMALL_IMAGE"};
        tokenizer.setNames(tokens);
        reader.setResource(inputCsv);
        System.out.println("File not found :: " + counter + "  :::");
        DefaultLineMapper<Taxonomy> lineMapper = new DefaultLineMapper<Taxonomy>();
        lineMapper.setLineTokenizer(tokenizer);
        BeanWrapperFieldSetMapper beanWrapper = new BeanWrapperFieldSetMapper<Taxonomy>();
        beanWrapper.setTargetType(Taxonomy.class);
        lineMapper.setFieldSetMapper(beanWrapper);
        reader.setLineMapper(lineMapper);
        return reader;
    }

    @Bean
    public TaxonomyWriter<Taxonomy> writer() {
        return new TaxonomyWriter<Taxonomy>();
    }

    @Bean
    public ItemProcessor<Taxonomy, Taxonomy> csvTaxonomyProcessor() {
        return new TaxonomyProcessor();
    }

    @Bean
    public String testFunction() {
        return "In Test Function";
    }
}
