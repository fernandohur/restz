# Restz
A wrapper for http-request + Gson to consume json RESTful web services. Restz uses Gson to convert json to Java Objects 
and http-request to make the actual request. This tutorial shows how to do some basic stuff.

## How to use Restz
Restz is built for lazy dummies like me in mind, so using it is easy. 

### How to instantiate Restz

The default way to instantiate Restz is as follows

```java
 Restz restz = new HttpRequestRestz();
```
### Get requests
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












