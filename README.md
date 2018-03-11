# Recipebok

**This is a project for the DAT076 course at Chalmers.**

Members of this group are:

**Raha Dadgar** - Git: DaRaha

**August Lennar** - Git: Lentx

**Sabrina Samuelsson** - Git: SabbePadde

**Mickaela Södergren** - Git: Kaffemakarn

**Supervisor:** Daniel Hausknecht

## Technical Difficulties

The first iteration of the application used IntelliJ as IDE and Tomcat as server. There were a lot of problems running the project however, and for a long time no one could run the application. Finally, it was decided to migrate to another git repo (this one) and the first git repo was abandoned. 

The second iteration of the application used Netbeans as IDE and TomEE as server. Midway through the project, with only two weeks left to the deadline, the application stopped running for everyone. At this point the core package was completed. After supervision, it was decided to make a third iteration of the application.

The third and final iteration of the application still used Netbeans as IDE, but used Glassfish 5.0 as server instead. A branch was created (maybe-database), where the new server was first introduced. Because of fear of breaking the application yet again, the group decided to stay in the maybe-database branch and continue develop there instead. At this point in time, the application was running for everyone, but there was only *4 days left to deadline*. 

The group has together developed the application in only 4 days and this is the result of it.

### Git inspector
Please note that because we have had so many technical issues (as out superviser Daniel can attest to), the git history does not accurately represent who wrote what code. We have had to migrate the project several times between different repositories, different branches etc. and we have also done a lot of pair programming.

We in group 5 will vouch for each other that everyone have done the same amount of work.

## How to run

To run this application, please use **Netbeans**.

Install **Glassfish 5.0** and **postgreSQL** in netbeans and perform the neccessary configurations to get them up and running.

### Trouble shooting

If you have any problems running the application, try to *Clean and Build* first. 

Make sure your persistence file is configured correctly. 

Make sure you have a glassfish-resources.xml in your WEB-INF folder.
