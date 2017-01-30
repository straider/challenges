:: Installation Sequence ::
===========================

# Sections

## Windows 10

- Enable Dark Theme (System and Apps);
- Windows Explorer:
    - Folder Options:
        - Enable Show Hidden files, folders and drives;
        - Disable Hide extensions for known file types;
        - Enable Restore previous folder at Windows logon;
        - Enable Navigation Pane: Expand to Open Folder.

## General

### Metapad

Settings:
- General: Insert Tabs as Spaces;
- Advanced: Default file format: Unix Text.

### Notepad++

Installation:
- Choose Components: Allow plugins to be loaded from %APPDATA%;

Settings:
- New Document: Format: Unix;
- Language:
    - Language Menu: Check "Make language menu compact"
    - Tab Settings: Tab size 4, replaced by space.

Update Plugin Manager and use it to install these plugins:
- [NppFTP 0.26.3](http://ashkulz.github.io/NppFTP/);
- [TextFX 0.2.6](http://textfx.no-ip.com/textfx/)
- [Tidy2 0.2](http://code.google.com/p/npp-tidy2/)
- [XML Tools 2.4.8]()

**Note**: configure Plugin Manager to install plugins for all users.

### MdCharm

Settings;
- Environment: General: System: Uncheck Show Splash;
- Text Editor:
    - Font & Color: Consolas;
    - Behavior: Enable Spellcheck;
    - Display:
        - Display line number;
        - Highlight current line.
    
### 7-Zip

Options:
- System:
    - Associate 7-Zip with all.
- Editor:
    - Editor: C:\Program Files (x86)\metapad.exe.

## Networking

### Chrome

### Thunderbird

Restore profile from latest backup.

### Skype

- Uncheck "Make Bing my search engine";
- Uncheck "Make MSN my homepage".

After installation then go to Tools -> Options -> Advanced -> Connection and uncheck "Use port 80 and 443 for additional incoming connections".

**Note**: to prevent Skype from starting with Windows then uncheck "Start Skype when I start Windows" option in the General settings tab.

### PuTTY

## Hosting

### Cygwin

Choose base installation, with chere (Shells).

After installation, configure mintty:
- Text
    - Font: Consolas 9;
    - Locale: en_GE with UTF-8.
- Windows: 120x45 (on 1366x768 displays).

Start Cygwin as Administrator, which will gather Windows Groups and User, and issue the following command  to install chere:

```bash
chere -in -t mintty -e "Cygwin Here"
```

If the following error occurs it's because of Windows UAC (permissions) and Cygwin must be run as Administrator:

```
Error (5): Access is denied.

/usr/bin/chere Error: Hive not writable
/usr/bin/chere: Aborting.
```

### MinGW

#### 32 bit and MSYS

Run mingw-get-setup.exe:
- Install to ```C:\Hosting\mingw\32\```;
- Uncheck install support for graphical user interface;
- Edit C:\mingw\32\var\lib\mingw-get\data\profile.xml and fix MSYS path as shown below;

```xml
    ...
    <sysroot subsystem="MSYS" path="%R/../msys" />
    ...
```

Execute MinGW Installation Manager and mark these for installation:
- mingw-developer-toolkit;
- msys-wget.

#### 64 bit

Run mingw-264-install.exe:
- Architecture: x86_64
- Threads: win32 (posix runs slower and seems to cause compiling problems?)
- Exceptions: seh
- Install to ```C:\Hosting\mingw\```.

After installation:
- Rename the sub-folder mingw64 to 64;
- Fix the mingw-64.bat, removing the mingw64/ sub-folder.
- Edit the **fstab** file in ```C:\Hosting\mingw\32\msys\1.0\etc\```:
```bash
# C:/Hosting/mingw/32 /mingw
C:/Hosting/mingw/64 /mingw
C:/Users            /home
```

### Git for Windows

- Install to ```C:\Hosting\Git\```;
- Select "Use a TrueType font in all console windows";
- Select "Checkout as-is, commit as-is".

### VirtualBox

Install to ```C:\Hosting\VirtualBox\```.

**Note**: make sure that C:\Hosting\ is not read-only and user has full control.

After installation change preferences:
- General: Default Machine Folder: ```C:\Hosting\VirtualBox VMs\```;
- Update: "Uncheck Check for Updates".

### Vagrant

- Install to ```C:\Hosting\Vagrant\```;
- Requires a restart:
- Install the following plugins:
    - ~~vagrant-vbguest 0.13.0~~
    - vagrant-proxyconf 1.5.2
    - vagrant-hostmanager 1.8.5

Issue the following command on a Windows Command Prompt window to install Vagrant plugins:

```bash
vagrant plugin install vagrant-proxyconf vagrant-hostmanager
```

Validate the the plugins are installed:

```
vagrant plugin list
```

### Docker Toolbox

- Install to ```C:\Hosting\Containers\Docker Toolbox\```;
- Uncheck VirtualBox;
- Uncheck Git for Windows;
- Edit Docker Quickstart Terminal Properties:
    - Fix target to use Git for Windows bash, in ```C:\Hosting\Git\bin\```.

### OpenShift

#### Container Developer Kit

- Unzip OpenShift Client Tools 1.3.2 to ```C:\Hosting\Containers\OpenShift\ClientTools\1.3.2\```;
- Unzip CDK 2.3.0 to ```C:\Hosting\Containers\OpenShift\ContainerDeveloperKit\2.3.0\```;
- Copy RHEL CDK 7.3 VirtualBox / HyperV Vagrant boxes to ```C:\Hosting\Containers\OpenShift\ContainerDeveloperKit\2.3.0\cdk\components\rhel```;
- Clone pristine rhel/rhel-ose/ sub-folder to a new sub-folder under rhel/ and edit the BOX_NAME property in the Vagrantfile for each new OpenShift Container Platform 3.3 to work with;
- Follow the [CDK Installation Guide for Windows 10](https://github.com/straider/challenges/blob/master/LearningPath/2017/EnterpriseContainerisation/OpenShift/OpenShift%20Container%20Platform/Windows%2010/CDK.md). **Note**: replace occurrences of **oscp-3.3** with edited value of BOX_NAME and make sure that Cygwin **openssh** and **rsync** packages are installed before following the steps.

**Note**: bare in mind that it's required to have a valid Red Hat Subscription.

#### Docker Cluster

#### Origin All-in-One Vagrant Box

- Create folder ```C:\Hosting\Containers\OpenShift\origin-all-in-one\```;
- Open a Windows Command Prompt and issue the following commands:

```bash
vagrant init openshift/origin-all-in-one
vagrant up --provider=virtualbox
```

#### minikube

#### minishift

#### gofabric8

## Coding

### WinMerge

- Install to ```C:\DevKits\Tools\WinMerge\```;
- Select Plugins.

Options:
- General:
    - Automatically scroll to first difference;
    - Disable Splash Screen;
    - Enable multiple compare windows for Folder compare.
- Compare: 
    - General: Enable moved block detection.
- Editor: Insert spaces;
- System: External editor: C:\Program Files (x86)\metapad.exe;
- Backup Files:
    - Create backup files into: Global backup folder: ```C:\Temp\```;
    - Backup filename:
        - Uncheck "Append .bak -extension";
        - Check "Append timestamp".
- Shell Integration:
    - Explorer: Enable advanced menu;
    - Folder compare: Add shell menu to context menu.

**Note**: activate filter **Exclude Source Control** or create a new one.
 
### TortoiseSVN

Install to ```C:\DevKits\VersionControl\TortoiseSVN\```, with command line client tools.

### TortoiseGit

Install to ```C:\DevKits\VersionControl\TortoiseGit\```.

After installation it's mandatory to configure user and email.

### Compilers

#### Java 5u22

Install to ```C:\DevKits\Java\jdk5u22\```.

Do not register with browser.

#### Java 6u45

Install to ```C:\DevKits\Java\jdk6u45\```.

#### Java 7u80

Install to ```C:\DevKits\Java\jdk7u80\```.

#### Java 8u112

Install to ```C:\DevKits\Java\jdk8u112\```.

Set JAVA_HOME environment variable to ```C:\DevKits\Java\jdk8u112\```.

#### Build Tools

##### Ant

Add ```C:\DevKits\Java\ant-1.10.0\bin\``` to DEVKITS environment variable.

##### Maven

Add ```C:\DevKits\Java\maven-3.3.9\bin\``` to DEVKITS environment variable.

##### Gradle

Add ```C:\DevKits\Java\gradle-3.2.1\bin\``` to DEVKITS environment variable.

### Interpreters

#### Groovy

Install to ```C:\DevKits\Java\groovy-2.4.7\```.

**Note**: without JAVA_HOME set the installation fails to find a proper JDK and switches to 32 bit mode. Configure JAVA_HOME to point to the JDK, instead of the JRE which is done by default.

#### JRuby

Install to ```C:\DevKits\Java\jruby-9.1.6.0\```.

#### Jython

Install to ```C:\DevKits\Java\jython-2.7.0\```.

#### Python

Customize installation:
- Add Python 3.6 to PATH;
- Install for all users;
- Install to ```C:\DevKits\Python\3.6.6\```.

#### Ruby

- Install to ```C:\DevKits\Ruby\2.3.3\```;
- Select:
    - Install Tcl/Tk support;
    - Add Ruby executables to your PATH;
    - Associate .rb and .rbw files with this Ruby installation.

#### Javascript

##### node.js

Install to ```C:\DevKits\Javascript\nodejs\7.4.0\```.

### IDEs

#### NetBeans

- Uncheck all;
- Check Base IDE;
- Check Java SE;
- Check Java EE (requires HTML5 /JavaScript);
- Check Groovy;
- Check Features on Demand;
- Install to ```C:\DevKits\IDEs\NetBeans 8.2\```.

**Note**: without JAVA_HOME set the installation fails to find a proper JDK and switches to 32 bit mode.

#### Eclipse

Install to ```C:\DevKits\IDEs\Eclipse Neon\```.

#### IDEA

- Install to ```C:\DevKits\IDEs\Geany\```;
- Enable Create Desktop shortcut: 32-bit launcher and 64-bit launcher;
- Enable Create associations: .java, .groovy, .kt;

After installation configure Settings:
- Appearance & Behavior
    - Appearance: UI Options: Theme: Dracula
- Build, Execution, Deployment
    - Build Tools:
        - Maven: Maven home directory: C:/DevKits/Java/maven-3.3.9

Install plugins:
- Markdown support 2016.3.20161109
- Gherkin 163.7743.44
- Cucumber for Java 163.9693
- Cucumber for Groovy 163.7743.44
- Docker integration 2.4.1

#### Geany

- Install to ```C:\DevKits\IDEs\Geany\```;
- Uncheck Language Files;

## Windows 10

### Environment Variables

#### HOSTING

Issue the following command from a Windows Command Prompt run as Administrator to set system wide environment variable HOSTING:

```bash
setx /M HOSTING "C:\Hosting\Git\cmd;C:\Hosting\Git\bin;C:\Hosting\Vagrant\bin;C:\Hosting\Containers\Docker Toolbox;C:\Hosting\Containers\OpenShift\ClientTools\1.3.2;"
```

#### DEVKITS

Issue the following command from a Windows Command Prompt run as Administrator to set user specific environment variables, especially DEVKITS:

```bash
setx JAVA_HOME   "C:\DevKits\Java\jdk8u112"
setx ANT_HOME    "C:\DevKits\Java\ant-1.10.0"
setx MAVEN_HOME  "C:\DevKits\Java\maven-3.3.9"
setx GRADLE_HOME "C:\DevKits\Java\gradle-3.2.1"
setx GROOVY_HOME "C:\DevKits\Java\groovy-2.4.7"
setx RUBY_HOME   "C:\DevKits\Ruby\2.3.3"
setx JRUBY_HOME  "C:\DevKits\Java\jruby-9.1.6.0"
setx PYTHON_HOME "C:\DevKits\Python\3.6.0"
setx JYTHON_HOME "C:\DevKits\Java\jython-2.7.0"
setx NODEJS_HOME "C:\DevKits\Javascript\nodejs\7.4.0"

setx DEVKITS "%JAVA_HOME%\bin;%ANT_HOME%\bin;%MAVEN_HOME%\bin;%GRADLE_HOME%\bin;%GROOVY_HOME%\bin;%RUBY_HOME%\bin;%NODEJS_HOME%;%JRUBY_HOME%\bin;%PYTHON_HOME%\Scripts\;%PYTHON_HOME%\;%JYTHON_HOME%\bin;C:\DevKits\VersionControl\TortoiseSVN\bin;C:\DevKits\VersionControl\TortoiseGit\bin;"
```

**Note**: This also fixes JAVA_HOME, from the default JRE to the JDK, which must be done before installing Groovy.

#### PATH

Issue the following command from a Windows Command Prompt run as Administrator to set system wide environment variable PATH:

```bash
setx /M PATH "%SystemRoot%\system32;%SystemRoot%;%SystemRoot%\System32\Wbem;%SystemRoot%\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\PuTTY\;C:\Program Files (x86)\Skype\Phone\;%HOSTING%"
```

Issue the following command from a Windows Command Prompt to set user specific environment variable PATH:

```bash
setx PATH "%USERPROFILE%\AppData\Local\Microsoft\WindowsApps;%DEVKITS%"
```
