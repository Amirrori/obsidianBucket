# Obsidian bucket is an open-source mod for Fabric.

This mod is mainly focused on decoration and being useless at most times but adding slight detail to the game!

### Features:

- Obsidian Bucket: The actual obsidian bucket, crafted from a Water Bucket and a Lava Bucket placed anywhere in a crafting grid (you get both empty buckets back).
- Molten Obsidian: Smelt an Obsidian Bucket in a Blast Furnace. You can also get 9 of these by putting a Molten Obsidian Block into a crafting table.
- Molten Obsidian Block: A decoration block made from 9 Molten Obsidian in a crafting table. It glows (light level 10) and needs a diamond pickaxe to mine.

All three show up in the creative inventory: the bucket under Tools & Utilities, Molten Obsidian under Ingredients and the block under Natural Blocks.

### Installation:

- Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 1.20.1 (0.14.22 or newer).
- Download [Fabric API](https://modrinth.com/mod/fabric-api) for 1.20.1.
- Put `obsidianBucket-<version>.jar` and Fabric API in your `mods` folder.
- Multiplayer: the server and every player need the mod and Fabric API.

### Building from source:

Requires JDK 17 (newer JDKs can't run this project's Gradle version).

```
git clone https://github.com/Amirrori/obsidianBucket.git
cd obsidianBucket
./gradlew build
```

The mod jar is in `build/libs/` (use the one without `-sources`).
To try it in a development client, run `./gradlew runClient`.

### License:

MIT, see [LICENSE](LICENSE).
