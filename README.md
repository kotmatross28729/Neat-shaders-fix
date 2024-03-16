# Neat (1.7.10) - shaders fix

## requires [unimixins](https://github.com/LegacyModdingMC/UniMixins) from 1.0.2 version!

A mod that adds a health bar to mobs, but now works with shaders.

<details>

<summary>Several demonstrations:</summary>

https://github.com/kotmatross28729/Neat-shaders-fix/assets/110309314/59118c49-89c1-4e6f-a02d-31138f16548a


https://github.com/kotmatross28729/Neat-shaders-fix/assets/110309314/01cc3602-fc13-4f21-a7ef-80ea453b84e6




https://github.com/kotmatross28729/Neat-shaders-fix/assets/110309314/2d1986c9-5279-4351-ab1b-acf47d69dd5d






<details>

<summary>Idk why, but one of the bugs during development</summary>



https://github.com/kotmatross28729/Neat-shaders-fix/assets/110309314/1480d34f-f359-4a28-8bd7-eab3000562fc




</details>









</details>

### Changes:
1) Fixed bar above mobs scale not depending on the screen resolution / GUI scale in the mc settings

2) Fixed bar above mobs being displayed incorrectly when `B:"Only show the health bar for the entity looked at"=false`

3) Fixed a bug where bars would not display on top of the player even if `B:"Display on Players"=true`

4) Fixed compatibility with shaders

5) Added config options with which you can disable the rendering of name tags above mobs and player nickname (can be turned on/off separately), enabled by default

6) Added config option with which you can make the bars above mobs appear only if the player wearing hbm's ntm armor with the "Enemy HUD" bonus (It only works if hbm is loaded, it is disabled by default, however, the health of mobs when you wear armor with "Enemy HUD" ( name tag above them) is removed, since it is also regulated by an option that removes the name tag above mobs)

# Credits:

[Vazkii](https://github.com/Vazkii) - [original mod](https://github.com/VazkiiMods/Neat)

[cosmicdan](https://github.com/cosmicdan) -
[Fork Neat for 1.7.10, which this one is based on](https://github.com/HostileNetworks/Neat)

[GTNH](https://github.com/orgs/GTNewHorizons/repositories) - [ExampleMod1.7.10](https://github.com/GTNewHorizons/ExampleMod1.7.10)
