package blanco.adapter.database.model;

public class CustomerKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CUSTOMER.customer_id
     *
     * @mbg.generated
     */
    private String customerId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CUSTOMER.customer_id
     *
     * @return the value of CUSTOMER.customer_id
     *
     * @mbg.generated
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CUSTOMER.customer_id
     *
     * @param customerId the value for CUSTOMER.customer_id
     *
     * @mbg.generated
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CUSTOMER
     *
     * @mbg.generated
     */
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
        CustomerKey other = (CustomerKey) that;
        return (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CUSTOMER
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        return result;
    }
}