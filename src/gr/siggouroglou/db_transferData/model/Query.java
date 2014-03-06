package gr.siggouroglou.db_transferData.model;

import java.util.ArrayList;
import java.util.List;

public class Query {

    private String name;
    private boolean bufferenable;
    private String select;
    private List<String> selectParameterList;
    private List<String> selectColumn;
    private String insert;
    private List<String> insertColumnList;

    public Query() {
        this.name = "";
        this.bufferenable = false;
        this.select = "";
        this.selectParameterList = new ArrayList<>();
        this.selectColumn = new ArrayList<>();
        this.insert = "";
        this.insertColumnList = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters-Setters">
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBufferenable() {
        return this.bufferenable;
    }

    public void setBufferenable(boolean bufferenable) {
        this.bufferenable = bufferenable;
    }

    public String getSelect() {
        return this.select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public java.util.List<String> getSelectParameterList() {
        return this.selectParameterList;
    }

    public void setSelectParameterList(java.util.List<String> selectParameterList) {
        this.selectParameterList = selectParameterList;
    }

    public java.util.List<String> getSelectColumn() {
        return this.selectColumn;
    }

    public void setSelectColumn(java.util.List<String> selectColumn) {
        this.selectColumn = selectColumn;
    }

    public String getInsert() {
        return this.insert;
    }

    public void setInsert(String insert) {
        this.insert = insert;
    }

    public java.util.List<String> getInsertColumnList() {
        return this.insertColumnList;
    }

    public void setInsertColumnList(java.util.List<String> insertColumnList) {
        this.insertColumnList = insertColumnList;
    }
    //</editor-fold>
}
