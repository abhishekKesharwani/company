package com.bedbath.springbatchexercise2.model;

public class Taxonomy {
    private Integer CHILD_CAT_ID;
    private Integer CATEGORY_ID;
    private String DISPLAY_NAME;
    private Integer IS_COLLEGE;
    private Integer NODE_TYPE;
    private Integer PHANTOM_CATEGORY;
    private Integer GUIDE_ID;
    private String SMALL_IMAGE;

    @Override
    public String toString() {
        return "Taxonomy{" +
                "CHILD_CAT_ID=" + CHILD_CAT_ID +
                ", CATEGORY_ID=" + CATEGORY_ID +
                ", DISPLAY_NAME='" + DISPLAY_NAME + '\'' +
                ", IS_COLLEGE=" + IS_COLLEGE +
                ", NODE_TYPE=" + NODE_TYPE +
                ", PHANTOM_CATEGORY=" + PHANTOM_CATEGORY +
                ", GUIDE_ID=" + GUIDE_ID +
                ", SMALL_IMAGE='" + SMALL_IMAGE + '\'' +
                '}';
    }

    public Integer getCHILD_CAT_ID() {
        return CHILD_CAT_ID;
    }

    public void setCHILD_CAT_ID(Integer CHILD_CAT_ID) {
        this.CHILD_CAT_ID = CHILD_CAT_ID;
    }

    public Integer getCATEGORY_ID() {
        return CATEGORY_ID;
    }

    public void setCATEGORY_ID(Integer CATEGORY_ID) {
        this.CATEGORY_ID = CATEGORY_ID;
    }

    public String getDISPLAY_NAME() {
        return DISPLAY_NAME;
    }

    public void setDISPLAY_NAME(String DISPLAY_NAME) {
        this.DISPLAY_NAME = DISPLAY_NAME;
    }

    public Integer getIS_COLLEGE() {
        return IS_COLLEGE;
    }

    public void setIS_COLLEGE(Integer IS_COLLEGE) {
        this.IS_COLLEGE = IS_COLLEGE;
    }

    public Integer getNODE_TYPE() {
        return NODE_TYPE;
    }

    public void setNODE_TYPE(Integer NODE_TYPE) {
        this.NODE_TYPE = NODE_TYPE;
    }

    public Integer getPHANTOM_CATEGORY() {
        return PHANTOM_CATEGORY;
    }

    public void setPHANTOM_CATEGORY(Integer PHANTOM_CATEGORY) {
        this.PHANTOM_CATEGORY = PHANTOM_CATEGORY;
    }

    public Integer getGUIDE_ID() {
        return GUIDE_ID;
    }

    public void setGUIDE_ID(Integer GUIDE_ID) {
        this.GUIDE_ID = GUIDE_ID;
    }

    public String getSMALL_IMAGE() {
        return SMALL_IMAGE;
    }

    public void setSMALL_IMAGE(String SMALL_IMAGE) {
        this.SMALL_IMAGE = SMALL_IMAGE;
    }
}
