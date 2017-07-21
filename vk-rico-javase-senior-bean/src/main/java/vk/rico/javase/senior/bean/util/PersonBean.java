package vk.rico.javase.senior.bean.util;

import java.math.BigDecimal;

/**
 * 子类继承父类，Java的内省
 * 
 * @author liangxf
 *
 */
public class PersonBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4060187414390372143L;

	private String name;
	private Integer age;
	private String mN;

	private Float score;
	private Double money;
	private Boolean flag;
	private BigDecimal amount;

	private Long Total;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getmN() {
		return mN;
	}

	public void setmN(String mN) {
		this.mN = mN;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getTotal() {
		return Total;
	}

	public void setTotal(Long total) {
		Total = total;
	}
}
