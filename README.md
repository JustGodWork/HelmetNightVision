# HelmetNightVision
HelmetNightVision is a Minecraft plugin that grants players night vision when they wear specific helmets. This plugin is built using the PaperMC API and supports **Minecraft version 1.21**.

## Features
Automatically grants night vision to players wearing specified helmets.
Removes night vision when players remove the specified helmets.

## Installation

- Download the latest release of the plugin from the [latest release page](https://github.com/JustGodWork/HelmetNightVision/releases/latest).
- Place the downloaded JAR file into your server's `plugins` directory.
- Start or restart your Minecraft server.

## Configuration
The plugin can be configured via the config.yml file located in the plugins/HelmetNightVision directory. The default configuration is as follows:
```
night-vision-helmets:
  - TURTLE
  # - LEATHER
  # - CHAINMAIL
  # - IRON
  # - GOLD
  # - DIAMOND
  - NETHERITE
```

Uncomment the helmets you want to grant night vision to players when worn.

## Building from Source
To build the plugin from source, follow these steps:

Clone the repository:

- Build the project using Gradle:
    ```
    git clone https://github.com/yourusername/HelmetNightVision.git
    cd HelmetNightVision
    ```
- The built JAR file will be located in the libs directory.

## Usage
Once the plugin is installed and configured, players will automatically receive night vision when they wear one of the specified helmets. The night vision effect will be removed when they take off the helmet.

## Code Overview
- HelmetNightVision: The main class of the plugin.
- PlayerController: Handles player events related to armor changes.
- NightVisionHelmet: Enum representing the different types of helmets that can grant night vision.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Contact
For any questions or suggestions, please open an issue on GitHub.

***Enjoy your enhanced night vision experience in Minecraft!***
