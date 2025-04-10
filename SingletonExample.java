import java.io.*;

class SingletonExample
{
	public static void main(String[] args) throws Exception
	{
		Sun s1 = Sun.getObject();
		//Sun s2 = Sun.getObject();
		//Sun s3 = Sun.getObject();

		//verifying if same object was returned
		//System.out.println(s1.hashCode());
		//System.out.println(s2.hashCode());
		//System.out.println(s3.hashCode());
		//System.out.println("Number of Objects created = " + Sun.objCount);

		//1. Serialize (s1)
		FileOutputStream fos = new FileOutputStream("example1.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();

		//2. Deserialize(s2)
		FileInputStream fis = new FileInputStream("example1.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Sun s2 = (Sun)ois.readObject(); //Down casting
		ois.close();
		fis.close();		
		
		//3. Compare the hashCodes of s1 and s2
		System.out.println("HashCode of initial object: " + s1.hashCode());
		System.out.println("HashCode of Serialized object: " + s2.hashCode());
	}
}

//Singleton class - only one object for this class will be created
class Sun implements Serializable
{
	public static final long serialVersionUId = 1L;
	static int objCount = 0;
	static Sun object;

	private Sun() //Declaring private consturctor, when we dont want instances to be created
	{	
		objCount++;
		System.out.println("Constructor was called" + " new Object created!");
	}

	public static Sun getObject()
	{
		if (objCount == 0)
		{
			object = new Sun();
		}
		else {
			System.out.println( "New Object not created!");
		}
		return object;		
	}
	
	//To ensure the same instance is returned during deserialization (Comment this and singleton is broken, 2 objects are created)
	protected Object readResolve() {
		return getObject();
	}
}	
