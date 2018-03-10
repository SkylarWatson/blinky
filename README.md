# Blinky
Blinky is a Java wrapper around [Blink(1)](https://blink1.thingm.com/).  It was initially written to manage Blink(1) USB operations programmatically.  

## Maven Dependency

```xml
<dependency>
  <groupId>com.skylarwatson</groupId>
  <artifactId>blinky</artifactId>
  <version>1.1</version>
</dependency>
```

## Usage

First initialize your blinky project

```java
public class Main {
    public static void main(String[] args) {
        new BlinkApplicationRunner().run();
    }
}
```

Next, you'll want to create a blink rule

```java
@Blinker
public class BlinkDemo implements BlinkRule {
    @Override
    public boolean illuminate() {
        return true;
    }
}
```

If `illuminate()` returns `true` blink(1) USB will turn red
