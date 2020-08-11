DROP TABLE TAXONOMY IF EXISTS;

CREATE TABLE TAXONOMY  (
    CHILD_CAT_ID BIGINT IDENTITY NOT NULL PRIMARY KEY,
    CATEGORY_ID BIGINT,
    DISPLAY_NAME VARCHAR(20),
    IS_COLLEGE INT,
    NODE_TYPE INT,
    PHANTOM_CATEGORY INT,
    GUIDE_ID INT,
    SMALL_IMAGE VARCHAR(20)
);