# HubParkour

Welcome to HubParkour, the ultimate Hub Parkour solution!

## Fr-version

This is not the official repository, this repository only serve to implement some fixes
And add some language support for french that are not modifiable in config

## Installation

For installation instructions, please follow the instructions located on the [spigot page](https://www.spigotmc.org/resources/hubparkour.47713/).

## Developer API

### Using the API as a part of your plugin.

There are 2 methods of including the API in your plugin. You can either attach the JAR as a library in your IDE (not recommended), or you can add a Maven dependency in your `pom.xml`.

Maven:
```xml
<repositories>
       <repository>
            <id>hp-repo</id>
            <url>https://nexus.block2block.me/repository/HubParkour/</url>
        </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>me.block2block.hubparkour</groupId>
        <artifactId>hubparkour-api</artifactId>
        <version>2.7</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

**Note:** Old versions of the API have been removed from Nexus as it was causing issues with the current deployment. Please update your API version.

### Usage

The JavaDocs can be found [here](http://hubparkour.block2block.me/). The main class for the API is `HubParkourAPI` which can be used to get the player object and other misc things. A full list of methods is available on the JavaDoc page.

There are also several Events that come as a part of the plugin that can be listened to and cancelled. Again, a full list of Events are available in the JavaDocs

### Example

```java
import me.block2block.api.HubParkourAPI;
import me.block2block.api.events.player.ParkourPlayerStartEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class StartListener implements Listener {
    
    @EventHandler
    public void onStart(ParkourPlayerStartEvent e) {
        if (e.getPlayer().getPlayer().isFlying()) {
            e.setCancelled(true);
            e.getPlayer().getPlayer().sendMessage("You cannot start the parkour if you're flying!");
        }
        
        Bukkit.getLogger().info(HubParkourAPI.getParkour(1).getName());

    }

}
``` 


