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
- Settings:
    - New Document: Format: Unix;
    - Language: Tab size 4, replaced by space.

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

### PuTTY

## Hosting

### Cygwin

Choose base installation, with chere (Shells).

After installation, configure mintty:
- Text
    - Font: Consolas 9;
    - Locale: en_GE with UTF-8.
- Windows: 120x45 (on 1366x768 displays).

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
- General: Default Machine Folder: ```C:\Hosting\VirtualBox VMs\```.

### Vagrant

Requires a restart.

### Docker Toolbox

- Install to ```C:\Hosting\Containers\Docker Toolbox\```;
- Uncheck VirtualBox;
- Uncheck Git for Windows;
- Edit Docker Quickstart Terminal Properties:
    - Fix target to use Git for Windows bash, in ```C:\Hosting\Git\bin\```.
    
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

**Note**: without JAVA_HOME set the installation fails to find a proper JDK and switches to 32 bit mode.

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

#### Geany

- Install to ```C:\DevKits\IDEs\Geany\```;
- Uncheck Language Files;

## Windows 10

### Environment Variables

#### HOSTING

#### DEVKITS

#### PATH
