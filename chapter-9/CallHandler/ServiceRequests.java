public class ServiceRequests {
	String[] names = new String[10];
	
	public void addName(String name) throws ServiceBackupException{
		for(int i = 0; i < names.length; i++) {
			if(names[i] == null) {
				names[i] = name;
				return;
			}
		}
		
		throw new ServiceBackupException();
	}
	
	public void removeName(String name) throws NoServiceRequestException{
		for(int i = 0; i < names.length; i++) {
			if(names[i] == name) {
				names[i] = null;
				return;
			}
		}
		
		throw new NoServiceRequestException();
	}
	
	public String getName(int index) throws ArrayIndexOutOfBoundsException{
		return names[index];
	}
	
	public int getNumber() {
		int count = 0;
		
		for(int i = 0; i < names.length; i++) {
			if(names[i] != null) {
				count++;
			}
		}
		
		return count;
	}
}
