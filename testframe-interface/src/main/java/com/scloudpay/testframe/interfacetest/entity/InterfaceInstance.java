package com.scloudpay.testframe.interfacetest.entity;

import java.io.Serializable;

public class InterfaceInstance implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private String name;

    private String apiName;

    private String methodName;

    private Long returnRuleId;

    private Long sqlRuleId;

    private Long custRuleId;

    private String memo;
    
    //前端使用扩展属性
    private boolean check;
    
    public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public Long getReturnRuleId() {
        return returnRuleId;
    }

    public void setReturnRuleId(Long returnRuleId) {
        this.returnRuleId = returnRuleId;
    }

    public Long getSqlRuleId() {
        return sqlRuleId;
    }

    public void setSqlRuleId(Long sqlRuleId) {
        this.sqlRuleId = sqlRuleId;
    }

    public Long getCustRuleId() {
        return custRuleId;
    }

    public void setCustRuleId(Long custRuleId) {
        this.custRuleId = custRuleId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        InterfaceInstance other = (InterfaceInstance) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getApiName() == null ? other.getApiName() == null : this.getApiName().equals(other.getApiName()))
            && (this.getMethodName() == null ? other.getMethodName() == null : this.getMethodName().equals(other.getMethodName()))
            && (this.getReturnRuleId() == null ? other.getReturnRuleId() == null : this.getReturnRuleId().equals(other.getReturnRuleId()))
            && (this.getSqlRuleId() == null ? other.getSqlRuleId() == null : this.getSqlRuleId().equals(other.getSqlRuleId()))
            && (this.getCustRuleId() == null ? other.getCustRuleId() == null : this.getCustRuleId().equals(other.getCustRuleId()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getApiName() == null) ? 0 : getApiName().hashCode());
        result = prime * result + ((getMethodName() == null) ? 0 : getMethodName().hashCode());
        result = prime * result + ((getReturnRuleId() == null) ? 0 : getReturnRuleId().hashCode());
        result = prime * result + ((getSqlRuleId() == null) ? 0 : getSqlRuleId().hashCode());
        result = prime * result + ((getCustRuleId() == null) ? 0 : getCustRuleId().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", apiName=").append(apiName);
        sb.append(", methodName=").append(methodName);
        sb.append(", returnRuleId=").append(returnRuleId);
        sb.append(", sqlRuleId=").append(sqlRuleId);
        sb.append(", custRuleId=").append(custRuleId);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}