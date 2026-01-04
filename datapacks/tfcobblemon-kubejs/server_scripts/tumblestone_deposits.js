LootJS.modifiers(event => {
	event.addTableModifier(/tfc:deposit\/.*/).randomChance(0.25).addLoot("cobblemon:tumblestone");
	event.addTableModifier(/tfc:deposit\/.*andesite/).randomChance(0.1).addLoot("cobblemon:black_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*basalt/).randomChance(0.1).addLoot("cobblemon:black_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*dacite/).randomChance(0.1).addLoot("cobblemon:black_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*diorite/).randomChance(0.1).addLoot("cobblemon:black_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*gabbro/).randomChance(0.1).addLoot("cobblemon:black_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*granite/).randomChance(0.1).addLoot("cobblemon:black_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*rhyolite/).randomChance(0.1).addLoot("cobblemon:black_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*gneiss/).randomChance(0.1).addLoot("cobblemon:sky_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*marble/).randomChance(0.1).addLoot("cobblemon:sky_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*phyllite/).randomChance(0.1).addLoot("cobblemon:sky_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*quartzite/).randomChance(0.1).addLoot("cobblemon:sky_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*schist/).randomChance(0.1).addLoot("cobblemon:sky_tumblestone");
	event.addTableModifier(/tfc:deposit\/.*slate/).randomChance(0.1).addLoot("cobblemon:sky_tumblestone");

});