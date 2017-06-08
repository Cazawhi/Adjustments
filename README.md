Adjustments documentation
========================

Install
-------

You can open the existing source with eclipse and compile it into a JAR file,
but you can also (if you trust me) use the ready compiled JAR archive at the project root.
If you have a JAR file - insert in Plugins Folder of Spigot or Bukkit Server.
The Plugin is currently used on 1.10 Server and was previously used on 1.9 Server.
Installing it could be pretty useless for you. There is no config file, only hardcoded information because we don't need it. :D
When I have some time, i will make a big update involving a config file.

Usage
-----

The Plugin is mainly used for chat formatting. You should add the following permissions to your Server groups:

* **Guest:** No permissions
* **Member:** adjustments.member
* **Mod:** adjustments.moderator
* **Admin:** adjustments.admin

There are also some extra permissions for some commands:

* **Broadcasting:** adjustments.broadcast
* **Server closing:** adjustments.close
* **Being not kicked at Server closing:** adjustments.bypass
* **Permission to build and destroy:** adjustments.build
