class SingletonExample
{
	public static void main(String[] args)
	{
		Sun s1 = Sun.getObject();
		Sun s2 = Sun.getObject();
		Sun s3 = Sun.getObject();

		//verifying if same object was returned
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println("Number of Objects created = " + Sun.objCount);
	}
}

//Singleton class - only one object for this class will be created
class Sun
{
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
}