:: Groovy :: IDEs :: IDEA ::
============================

# Steps

## Using Java Project

## Using Maven Project

## Using Gradle Project

**Note**: Add Gradle plugin.

- Create HelloWorld using Gradle project;
    - Additional Libraries and Frameworks: Java, Groovy
- Change Project Settings:
    - Add main/groovy/ to src/ and mark it as Source Folder;
    - Add test/groovy/ to src/ and mark is as Test Folder;
    - Unmark src/.
- Add Groovy class as com.github.straider.HelloWorld;
- Auto generate Groovy test class, using Groovy JUnit;

## Using Groovy Project

**Note**: Add Groovy plugin.

- Create HelloWorld using Groovy project, using $HOME/opt/groovy/;
- Change Project Settings:
    - Add main/groovy/ to src/ and mark it as Source Folder;
    - Add test/groovy/ to src/ and mark is as Test Folder;
    - Unmark src/.
- Add Groovy class as com.github.straider.HelloWorld;
- Auto generate Groovy test class, using Groovy JUnit;
- Check that default greeting test is RED;
- Add missing method and check that default greeting test is GREEN.
