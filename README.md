# Restz
A wrapper for http-request + Gson to consume json RESTful web services. Restz uses Gson to convert json to Java Objects 
and http-request to make the actual request. This tutorial shows how to do some basic stuff.
Restz is made specifically to consume web services from Android, although it is general purpose.

## What is *Restz*?
Rest is a darn easy way to consume RESTful webservices with Json format. It basically does 2 things for you:
1. It makes the actual request i.e. the HTTP GET, PUT, POST, DELTE or whatever. 
2. It parses the result from a raw json string to a regular Java Object, so you don't have to.

### Is there a .jar?
Sure there is, you can download it using
```bash
$ wget https://github.com/fernandohur/restz/raw/master/jar/restz.jar
```
Or simply go to https://github.com/fernandohur/restz/blob/master/jar/restz.jar and click on *raw*

## How to use Restz
Restz is built for lazy dummies like me in mind, so it's easy to use. Follow these simple steps to learn how to make a GET and POST
(PUT and DELETE coming soon as well as Basic Auth)
### How to instantiate Restz

The default way to instantiate Restz is as follows

```java
 Restz restz = new HttpRequestRestz();
```
### How to make a simple GET requests
Now, given you have a Restz instance, you can do a Get request. 
Lets say we want to get my facebook data from https://graph.facebook.com/fernandohur

1. We define a class to hold the json object 

	```java
	class FacebookUser{
		String id;
		String name;
		String first_name;
		String last_name;
		String username;
		String gender;
		String locale;
	}
	```
	NOTE: the Objects attribute names must match the json's attribute names.
2. We use Restz to make an HTTP GET request to https://graph.facebook.com/fernandohur

	```java
	
	Restz restz = new HttpRequestRestz();
	FacebookUser user = restz.get("https://graph.facebook.com/fernandohur", FacebookUser.class);
	System.out.println("My name is "+ user.first_name)

	```
### How to make a GET request that returns a Json Array

So for this case let's asume you have a web servies that given the id of a user returns his friends as a list of FacebookUser, 
this could be done as follows:

```java
	//This is the ugly part. To get a List<FacebookUser> java.lang.reflect.Type you have to do the following
	Type type = new TypeToken<List<FacebookUser>>(){}.getType()
	// Now, you just call your regular .get method
	List<FacebookUser> friends = restz.get("https://your-server.com/api/v1/friends.json", 
		type , "user_id",user.id);
	
}
```

### How to make a simple POST

Let's say you have a webservice for saving the location of a particular user in your server. The web service is
called by making a POST to http://your-server.com/api/v1/locations.json and receives the latitude, longitude and 
id of the user and returns the created Location object. This could be done with Restz as follows:

```java
//First we create the Location object
class Location{
	private long userId;
	private double latitude;
	private double longitude;
}
//Given we have a Restz instance named restz, and a User class, we can do the following
Location newLoc = restz.post("http://your-server.com/api/v1/locations.json", Location.class, 
	"userId",user.getId(), "latitude",user.getCurrentLatitude(), "longitude",user.getCurrentLongitude());

System.out.println("The user's new location has been saved in the server :) ");
```

So as you can see, Restz handles creating the HTTP Request and parsing the result to a regular POJO. In this 
case the result should have been something like
```javascript
{
	"userId":123,
	"latitude":234.123
	"longitude":345.987
}
```

## Basic auth

TODO: basic auth is implemented using the class BasicAuthRestz











