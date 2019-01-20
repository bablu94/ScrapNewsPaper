# ScrapNewsPaper
newspaperscrapping

Frameworks:
	Spring 4.3

	Restful

Implementation:
	JDK used is 1.8. 

	Configure the .jar file which all are defined in pom.xml file.

	Use Tomcat Server for service requests.

	We need to pass the key author, author-title, pass to author-alldata that will parse on the basis of the searched key.

	Used postman.

Service Flow:
	Controller -> Service -> Given URL -> Parse HTML page by class/tag -> Return object (json file)
