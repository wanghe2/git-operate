package bean;

public  class User implements Cloneable{
	private volatile String name;

	private Address address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 浅拷贝--普通值，对象只是拷贝引用过去
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	/**
	 * 深拷贝--对象重新复制一个过去
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public User highClone() throws CloneNotSupportedException {
       User user= (User) super.clone();
       Address address=(Address) user.getAddress().clone();
       user.setAddress(address);
       return user;
    }
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
