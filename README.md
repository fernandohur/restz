# Restz
A wrapper for http-request + Gson to consume json RESTful web services. Restz uses Gson to convert json to Java Objects 
and http-request to make the actual request. This tutorial shows how to do some basic stuff.
Restz is made specifically to consume web services from Android, although it is general purpose.

## How to use Restz
Restz is built for lazy dummies like me in mind, so using it is easy. Follow these simple steps to learn how to make a GET, POST, PUT and DELETE

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











