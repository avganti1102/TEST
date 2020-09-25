package Ex6.Question1;

public class VietnamesePhone extends Phone {
	

	@Override
	public void insertContact(String name, String numb) {
			this.setName(name);
			this.setNumb(numb);
			System.out.println("Tên: " + getName());
			System.out.println("SÐT: " + getNumb());
	}

	@Override
	public void removeContact(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateContact(String name, String newNumb) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchContact(String name) {
		// TODO Auto-generated method stub

	}

}
