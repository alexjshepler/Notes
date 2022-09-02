# Windows

## ls

> List. Lists out all of the contents of a directory and basic information on all of the folders and files

~~~
ls [dir]? [args]
~~~

### Arguments and Parameters:

*`dir`* - Specifies what directory that you want to list out. If none is provided it will assume the current directory

*`-Force`* - Shows all hidden files and directories

*`-Filter [pattern]`* - Filter the results to only show the files that match the pattern

## Get-Help

> Gives information and a description of the given command. It also gives information on the arguments of the command

~~~
Get-Help [cmd] args
~~~

### Arguments and Parameters

*`cmd`* - The command that you want more information on

*`-Full`* - Gives more information on the command

## pwd

> Print Working Directory. Prints out the current directory that you are in

~~~
pwd
~~~

## cd

> Change Directory. Changes the current working directory

~~~
cd [dir]
~~~

### Arguments and Parameters

*`dir`* - The directory that you want to move to. This can be absolute or relative
- `..` Will take you up one level
    - `..` Can act as an absolute path so you can preform operations like `..\dir` and you will traverse horizontally
- `~` The path to the home directory
    - `~` Can also act as an absolute path so you can use this to get to directories that are in that file location
- `.` The current directory

## mkdir

> Makes a new directory

~~~
mkdir [name]
~~~

### Arguments and Parameters

*`name`* - The name of the new directory
- Spaces don't work so you need to do either:
    1) "Put the name between quotes"
    2) 'Put the name between single quotes'
    3) Put\` back\` ticks\` before\` every\` space

## cp

> Copies a file or directory 

~~~
cp [file] [location] [args]
~~~

### Arguments and Parameters

*`file`* - The file or location to the file that you want to copy

*`location`* - The location where you want to send the copied file to

*`-Recurse`* - Recursively copies files and folders. This is used when copying a directory

*`-Verbose`* - Gives output to the shell. By default cp doesn't give any output unless an error has occurred

## mv

> Moves a file from one directory or another, or it can be renamed if moved to the same directory with a different name

~~~
mv [original] [new]
~~~

### Arguments and Parameters

*`original`* - The original file or the location of the file

*`new`* - The new location of the file or the new name of the file

## rm

> removes a file or directory

~~~
rm [file] [args]
~~~

### Arguments and Parameters

*`-Force`* - Forces a file to be removed if you have the permissions for it

*`-Recurse`* - Recursively deletes all files and folders in the directory 

## cat

> Displays the content of a file

~~~
cat [file] [args]
~~~

### Arguments and Parameters

*`file`* - The file that you want to view

*`-Head N`* - Allows you to see the first *`N`* lines of the file

*`-Tail N`* - Allows you to see the last *`N`* lines of the file

## more

> Displays the contents of a file one page at a time

~~~
more [file]
~~~

### Arguments and Parameters

*`file`* - The file you want to view

`Enter` - Advances the file by one line at a time

`Space` - Advances the file by one page at a time

`q` - Allows you to quit out of the program and return to the terminal

## sls

> Searches through a file or direcory for a match of the input

~~~
sls [input] [location]
~~~

### Arguments and Parameters

*`input`* - The thing that you are searching for

*`location`* - The location where you are searching through

## Get-LocalUser

> Gets the user data for all users

~~~
Get-LocalUser
~~~

## Get-LocalGroup

> Gets the information on local groups


~~~
Get-LocalGroup
~~~

## Get-LocalGroupMember

> Get the information on local groups and who is in it

~~~
Get-LocalGroupMember [group]
~~~

### Arguments and Parameters

*`group`* - The group you want to see what members are apart of

## net

> Contains tools for the administrator for user management

~~~
net user [user] [password] [args]
~~~

### Arguments and Parameters

*`user`* - The user that you want to change the password to

*`password`* - The password that you want to set. If enter a * instead of a password. It will pause the execution and let you type a password in so it is not visible to to the terminal

*`/logonpasswordchg:yes`* - Forces the user to change their password when they next log on

*`/add`* - Adds a new user

*`/delete`* - Deletes an account

## icacls

> Allows you to view and change acls

~~~
icacls [location] [args] '[group/user]:[perms]'
~~~

### Arguments and Parameters

*`location`* - The location of where you want to see acls

*`/grant`* - Grants the user or group with the inputted permissions

*`/remove`* - Removes the users or group with the inputted permissions

*`group/user`* - The user or group that you want to modify the permissions for

*`perms`* - The permissions that you want to modify

There can be two types of permissions.
- A sequence of simple rights
    - N - No
    - F - Full
    - M - Modify
    - RX - Read and execute
    - R - Read-only
    - W - Write-only
    - D - Delete
- A comma-separated list of specific rights
    - DE - Delete
    - RC - Read Control
    - WDAC - Write DAC
    - WO - Write Owner
    - S - Synchronize
    - AS - Access System Security
    - MA - Maximum Allowed
    - GR - Generic Read
    - GW - Generic Write
    - GE - Generic Execute
    - GA - Generic All
    - RD - Read Data/List Directory
    - WD - Write Data/Add File
    - AD - Append Data/Add Subdirectory
    - REA - Read Extended Attributes
    - WEA - Write Extended Attributes
    - X - Execute/Traverse
    - DC - Delete Child
    - RA - Read Attributes
    - WA - Write Attributes
- Inheritance Rights
    - (OI) - Object Inherit
    - (CI) - Container Inherit
    - (IO) - Inherit Only
    - (NP) - Don't Propagate Inherit
    - (I) - Permission Inherited from Parent Container

## Compress-Archive

> Puts files into a compressed archive

~~~
Compress-Archive [args] [location]
~~~

### Arguments and Parameters

*`location`* - The location where you want to send the file. This will be the absolute path of the archived folder

*`-Path [location]`* - Set the path of the file or folder you want to archive and compress

## Find-Package

> Finds packages to be installed

~~~
Find-Package [package] [args]
~~~

### Arguments and Parameters

*`package`* - The package that you want to install

*`-IncludeDependencies`* - Includes all dependencies to be installed

## Register-PackageSource

> Registers a new package source so Windows looks there too when installing packages

~~~
Register-PackageSource [args]
~~~

### Arguments and Parameters

*`-Name`* - The name of the package source

*`-ProviderName`* - The providers name of the package source

*`-Location`* - The location where the package source is located

## Diskpart

> Terminal based disk partitioning tool

~~~
Diskpart
~~~

> Using this command will open up another terminal

### Commands, Arguments, and Parameters

*`list disk`* - Lists all of the disks and drives available to the user

*`select disk [disk]`* - Make the selected disk [disk]

*`clean`* - Formats the selected disk

*`create partition primary`* - Creates a primary partition on the selected disk

*`select partition [partition]`* - Selects the partition [partition]

*`active`* - Makes the currently selected partition active

*`format [args]`* - Formats the volume selected
    - *`FS=[system]`* - Sets the files system to [system]
    - *`label=[label]`* - Sets the label of the volume to [label]
    - *`quick`* - Makes it a quick format of the volume

## mklink

> Makes a symbolic link

~~~
mklink [args] [link] [file]
~~~

### Arguments and Features

*`/H`* - Makes a hard link

*`link`* - The name of the link you are creating

*`file`* - The file you are making the link for

### taskkill

> Kills a task

~~~
taskkill [args]
~~~

### Arguments and Parameters

*`/pid [id]`* - The process ID of the process that you want to kill

## Get-Service [name]

> Gets information about a service and if none is provided all will be listed

## Stop-Service [name]

> Stops a service

## Start-Service [name]

> Starts a service

## Restart-Service [name]

> Restarts a service

## New-ADGroup

> Makes a new Active Directory group

~~~
New-ADGroup [args]
~~~

### Arguments and Parameters

*`-Description:"[des]"`* - Sets the description [des] of the group

*`-GroupCategory:"[cat]"`* - Sets the group category

*`-GroupScope:"[scope]"`* - Sets the group scope


----------------------------------------------------------------------------------------------------------------------------------------------------------------

# Linux

## ls

> List. Lists out all of the contents of a directory with no extra information 

~~~
ls [args] [dir]?
~~~

### Arguments and Parameters

*`dir`* - The directory that you want to list all of the contents out. If none is provided it will assume the current directory

*`-l`* - Long. Gives more information on files and folders that its listing out. It gives information on file permissions, links, file owner, group, size, last modification timestamp, and file or directory name

*`-a`* - All. Shows all of the files and directories, including the hidden one

## --help

> This isn't a command but a flag. Add this flag to any command and it will give you more information on the command and the flags it can use

~~~
[cmd] --help
~~~

### Arguments and Parameters

*`cmd`* - The command that you want more information on

## man

> Manual. This gives the manual page on a given command

~~~
man [cmd]
~~~

### Arguments and Parameters

*`cmd`* - The command that you want to look the manual up for

## pwd

> Print Working Directory. Prints out the current directory that you are in

~~~
pwd
~~~

## cd

> Change Directory. Changes the current working directory

~~~
cd [dir]
~~~

### Arguments and Parameters

*`dir`* - The directory that you want to move to. This can be absolute or relative
- `..` Will take you up one level
    - `..` Can act as an absolute path so you can preform operations like `..\dir` and you will traverse horizontally
- `~` The path to the home directory
    - `~` Can also act as an absolute path so you can use this to get to directories that are in that file location
- `.` The current directory

## mkdir

> Makes a new directory

~~~
mkdir [name]
~~~

### Arguments and Parameters

*`name`* - The name of the new directory
- Spaces don't work so you need to do either:
    1) "Put the name between quotes"
    2) 'Put the name between single quotes'
    3) Put\ back\ slashes\ before\ every\ space

## cp

> Copies a file or directory 

~~~
cp [args] [file] [location]
~~~

### Arguments and Parameters

*`file`* - The file or location to the file that you want to copy

*`location`* - The location where you want to send the copied file to

*`-r`* - Recursively copies files and folders. This is used when copying a directory

*`-v`* - Gives output to the shell. By default cp doesn't give any output unless an error has occurred

## mv

> Moves a file from one directory or another, or it can be renamed if moved to the same directory with a different name

~~~
mv [original] [new]
~~~

### Arguments and Parameters

*`original`* - The original file or the location of the file

*`new`* - The new location of the file or the new name of the file

## rm

> removes a file or directory

~~~
rm [args] [file]
~~~

### Arguments and Parameters

*`-Force`* - Forces a file to be removed if you have the permissions for it

*`-Recurse`* - Recursively deletes all files and folders in the directory 

## cat

> Displays the content of a file

~~~
cat [file]
~~~

### Arguments and Parameters

*`file`* - The file that you want to view

## less

> Displays the contents of a file one page at a time

~~~
less [file]
~~~

### Arguments and Parameters

*`file`* - The file you want to view

`up` and `down` keys - Allows you to traverse through the document one line at a time

`pgdn` and `pgup` keys - Allows you to traverse through the document one page at a time

`g` - Moves to the beginning of a file

`G` - Moves to the end of a file

`/[word]` - Searches for [word]

`q` - Quits the program and returns to the shell

## head

> Shows you the first lines of a file. The default value is 10

~~~
head [file]
~~~

### Arguments and Parameters

*`file`* - The file that you want to view

## tail

> Shows you the last lines of a file. The default value is 10

~~~
tail [file]
~~~

### Arguments and Parameters

*`file`* - The file that you want to view

## nano

> A basic text editor

~~~
nano [file]
~~~

### Arguments and Parameters

*`file`* - The file that you want to edit. If it doesn't exist it will make a new file

## grep

> Search files for matches given an input

~~~
grep [input] [file]
~~~

### Arguments and Parameters

*`input`* - The thing you want to search for or pattern

*`location`* - Where you are searching

## sudo

> Allows any user to run commands as root or superuser

~~~
sudo [args] [command]
~~~

### Arguments and Parameters

*`command`* - The command that you want to run as root

*`su`* - Switches to that user so you don't have to type in sudo before every command
    `exit` - Signs out of the superuser account

## passwd

> Allows you to change peoples password

~~~
passwd [args] [user]
~~~

### Arguments and Parameters

*`user`* - The user that you want to change the password for

*`-e`* - Makes the user change their password on next logon. May have to sudo the command

## useradd

> Creates a new account

~~~
useradd [name]
~~~

### Arguments and Parameters

*`name`* - The name of the account that you want to create

## userdel

> Deletes an existing account

~~~
userdel [user]
~~~

### Arguments and Parameters

*`user`* - The username of the account that you want to delete

## chmod

> Changes the permissions of a file

~~~
chmod [target][+/-][perms] [location]
~~~

### Arguments and Parameters

*`target`* - The target of the permission change, u, g, or o

*`+/-`* - If you want to add or remove permissions. + for add, - for remove

*`perms`* - The perms that you want to add or remove, R for read, W for write, X for execute

*`location`* - The location of the file or folder that you want to change the permissions of

## chown

> Changes the owner of the file

~~~
chown [user] [location]
~~~

### Arguments and Parameters

*`user`* - The user you want to assign the owner of the file

*`location`* - The location of the file that you want to change the owner of

## chgrp

> Changes the group of the file

~~~
chgrp [group] [location]
~~~

### Arguments and Parameters

*`group`* - The group you want to assign to the file

*`location`* - The location of the file that you want to change the group of

## dpkg

> Package manager for deb files

~~~
dpkg [args] [file/package]
~~~

### Arguments and Parameters

*`file/package`* - The file or location of the file that you want to install. It can also be the package name

*`-i`* - Installs the package

*`-r`* - Removes the package

*`-l`* - Lists the packages

## 7z

> 7zip for linux allows you to zip and unzip files and archives

~~~
7z [args] [location]
~~~

### Arguments and Parameters

*`e`* - Extracts the files in the given location

*`location`* - The location where you want to use 7zip

## apt

> Package manager for linux

~~~
apt [args] [package]
~~~

### Arguments and Parameters

*`package`* - The package you want to preform actions on

*`install`* - Installs packages

*`update`* - Updates the package index and pull the latest changes

*`upgrade`* - Upgrades the installed packages

*`full-upgrade`* - Does the same thing as upgrade but will removed installed packages if it is required to upgrade the whole system. This will also install a new version of the kernel if it is available  

## uname

> Gives the user the system information

~~~
uname [args]
~~~

### Arguments and Parameters

*`-r`* - Kernel version number

## Parted

> Linux disk partition command. Can either be ran in an interactive mode or command mode

~~~
parted [args]
~~~

### Arguments and Parameters

*`-l`* - Shows the disks that are connected to the computer

*`location`* - The location to a drive (ie /dev/sdb) will put parted into interactive mode for that drive
    - *`print`* - Shows information about the disk
    - *`mklabel`* - Sets the partition table for the device
    - *`mkpart [partition] [fs] [start] [end]`* - Makes a partition on the current drive
        - *`partition`* - The type of partition you want to make
        - *`fs`* - The type of file system you want to have
        - *`start/end`* - The start and end of the partition that you want to have on the drive

## mkfs

> Formats a partition

~~~
mkfs [args] [location]
~~~

### Arguments and Parameters

*`-t [type]`* - The file type

*`location`* - The location of the partition (ie /dev/sdb1)

## mount

> Mounts drives to physical locations on the computer

~~~
mount [drive] [location]
~~~

### Arguments and Parameters

*`drive`* - The drive you are wanting to mount

*`location`* - The location where you are mounting the drive to

## umount

> Unmounts the drive

~~~
umount [drive/location]
~~~

### Arguments and Parameters

*`drive/location`* - The drive (ie /dev/sdb1) or the location of the mount point (ie /my_usb)

## mkswap

> Sets a partition to swap space

~~~
mkswap [location]
~~~

### Arguments and Parameters

*`location`* - The location of the swap space

## swapon

> Turn swap space on

~~~
swapon [location]
~~~

### Arguments and Parameters

*`location`* - The location of the swap space that you want to turn on

## service

> Do service related tasks

~~~
service [name] [arg]
~~~

### Arguments and Parameters

*`name`* - The name of the service you want to preform tasks on

*`status`* - Gets the status of the service inputted 

*`stop`* - Sends the stop signal, stopping the service

*`start`* - Sends the start signal, starting the service

*`restart`* - Sends the stop then start signal to the service, restarting it