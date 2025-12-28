import os
import copy
import json

berries = [
    {"berry": "oran", "biomes": ["all"]},
    {"berry": "cheri", "biomes": ["plains"]},
    {"berry": "chesto", "biomes": ["forest"]},
    {"berry": "pecha", "biomes" : [ "jungle", "swamp"]},
    {"berry": "rawst", "biomes": ["arid"]},
    {"berry": "aspear", "biomes": ["mountain"]},
    {"berry": "persim", "biomes": ["all"]},
    {"berry": "razz", "biomes": ["forest"]},
    {"berry": "bluk", "biomes": ["mountain", "taiga"]},
    {"berry": "nanab", "biomes": ["jungle", "swamp"]},
    {"berry": "wepear", "biomes": ["plains"]},
    {"berry": "pinap", "biomes": ["arid"]},
    {"berry": "occa", "biomes": ["jungle","sandy","thermal","volcanic"]},
    {"berry": "pasho", "biomes": ["coast","freshwater","island","ocean"]},
    {"berry": "wacan", "biomes": ["grassland", "hills", "sky"]},
    {"berry": "rindo", "biomes": ["jungle", "temperate", "lush"]},
    {"berry": "yache", "biomes": ["freezing", "taiga"]},
    {"berry": "chople", "biomes": ["mountain", "bamboo", "taiga"]},
    {"berry": "kebia", "biomes": ["forest","mushroom","spooky","swamp"]},
    {"berry": "shuca", "biomes": ["arid", "grassland"]},
    {"berry": "coba", "biomes": ["peak", "temperate", "sky"]},
    {"berry":"payapa", "biomes": ["desert", "floral", "magical", "savanna", "spooky"]},
    {"berry":"tanga", "biomes": ["forest", "jungle", "swamp"]},
    {"berry":"charti", "biomes": ["dripstone", "mountain", "sandy", "volcanic"]},
    {"berry": "kasib", "biomes": ["dripstone", "lush", "spooky", "swamp", "taiga"]},
    {"berry": "haban", "biomes": ["jungle", "magical", "mountain", "sky", "volcanic"]},
    {"berry": "colbur", "biomes": ["badlands", "spooky", "taiga"]},
    {"berry": "babiri", "biomes": ["bamboo", "mountain", "taiga"]},
    {"berry": "chilan", "biomes": ["temperate", "grassland"]}
]

base_placed_berry = {
  "feature": "tfcobblemon:plant/wild_crop/oran_berry",
  "placement": [
    {
      "type": "minecraft:heightmap",
      "heightmap": "WORLD_SURFACE_WG"
    },
    {
      "type": "block_predicate_filter",
      "predicate": {
        "type": "tfc:replaceable"
      }
    },
    {
      "type": "block_predicate_filter",
      "predicate": {
        "type": "would_survive",
        "state": {
          "Name": "cobblemon:oran_berry",
          "Properties": {
            "age": "1",
            "generated": "true"
          }
        }
      }
    }
  ]
}

base_configured_berry = {
  "type": "minecraft:simple_block",
  "config": {
    "to_place": {
      "type": "tfc:random_property",
      "state": {
        "Name": "cobblemon:oran_berry",
        "Properties": {
          "age": "1",
          "generated": "true"
        }
      },
      "property": "age"
    }
  }
}

base_placed_patch = {
  "feature": "tfcobblemon:plant/wild_crop/cheri_berry_patch",
  "placement": [
    {
      "type": "minecraft:heightmap",
      "heightmap": "WORLD_SURFACE_WG"
    },
    {
      "type": "minecraft:in_square"
    },
    {
	  "type": "minecraft:rarity_filter",
	  "chance": 50
    }
  ]
}

base_configured_patch = {
  "type": "minecraft:random_patch",
  "config": {
    "tries": 4,
    "xz_spread": 4,
    "y_spread": 1,
    "feature": "tfcobblemon:plant/wild_crop/cheri_berry"
  }
}

tfc_climate_map = {
    "freezing": {
        "type": "tfc:climate",
        "min_temperature": -33,
        "max_temperature": -10.4,
        "min_groundwater": 50,
        "max_groundwater": 470
    },
    "taiga": {
        "type": "tfc:climate",
        "min_temperature": -14.2,
        "max_temperature": 10.0,
        "min_groundwater": 60,
        "max_groundwater": 320,
        "min_forest": 2
    },
    "forest" : {
        "type": "tfc:climate",
        "min_groundwater": 100,
        "max_groundwater": 300,
        "min_forest": 2
    },
    "plains":  {
        "type": "tfc:climate",
        "min_temperature": -10.6,
        "max_temperature": 19.4,
        "min_forest": 0,
        "max_forest": 3
    },
    "grassland":  {
        "type": "tfc:climate",
        "min_temperature": -10.6,
        "max_temperature": 19.4,
        "min_forest": 0,
        "max_forest": 3
    },
    "arid" : {
        "type": "tfc:climate",
        "min_groundwater": 50,
        "max_groundwater": 260
    },
    "desert": {
        "type": "tfc:climate",
        "min_groundwater": 40,
        "max_groundwater": 170,
        "min_rain_variance": -1,
        "max_rain-variance": 1,
        "rain_variance_absolute": False
    },
    "mountain": {
        "type": "tfc:climate",
        "min_elevation": 75
    },
    "jungle": {
        "type": "tfc:climate",
        "min_temperature": 11.0,
        "max_temperature": 40,
        "min_groundwater": 280,
        "max_groundwater": 500,
        "min_forest": 2
    },
    "savanna": {
        "type": "tfc:climate",
        "min_temperature": 15.8,
        "max_temperature": 40,
        "min_groundwater": 100,
        "max_groundwater": 300,
        "min_forest": 0,
        "max_forest": 2
    },
    "swamp": {
        "type": "tfc:climate",
        "min_groundwater": 280,
        "max_groundwater": 500
    }
}

cobblemon_berry_patches = {
  "type": "minecraft:simple_random_selector",
  "config": {
	  "features": [
	  ]
  }
}

for berry_entry in berries:
    berry_name = berry_entry["berry"]
    berry_filename = f"{berry_name}_berry"
    patch_filename = f"{berry_name}_berry_patch"
    feature_berry_name = f"tfcobblemon:plant/wild_crop/{berry_filename}"
    feature_patch_name = f"tfcobblemon:plant/wild_crop/{patch_filename}"
    
    base_placed_berry["feature"] = feature_berry_name;
    base_configured_berry["config"]["to_place"]["state"]["Name"] = "cobblemon:" + berry_name + "_berry"
    
    placed_patch = copy.deepcopy(base_placed_patch)
    placed_patch["feature"] = feature_patch_name
    has_match = False
    biomes = berry_entry["biomes"]
    tfc_placement = None
    for biome in biomes:
        if tfc_climate_map.get(biome):
            placed_patch["placement"].append(tfc_climate_map.get(biome))
            print("Used " + biome + " for " + berry_name)
            has_match = True
            break;
    
    if biome == "all":
        has_match = True
    
    if not has_match:
        continue;
            
    base_configured_patch["config"]["feature"] = feature_berry_name
    
    with open(os.path.join("placed_feature", "plant", "wild_crop", berry_filename + ".json"), 'w') as f:
        json.dump(base_placed_berry, f, indent=4)
    
    with open(os.path.join("placed_feature", "plant", "wild_crop", patch_filename + ".json"), 'w') as f:
        json.dump(placed_patch, f, indent=4)
        
    with open(os.path.join("configured_feature", "plant", "wild_crop", berry_filename + ".json"), 'w') as f:
        json.dump(base_configured_berry, f, indent=4)
    
    with open(os.path.join("configured_feature", "plant", "wild_crop", patch_filename + ".json"), 'w') as f:
        json.dump(base_configured_patch, f, indent=4)
        
    cobblemon_berry_patches["config"]["features"].append(feature_patch_name)
        
with open(os.path.join("configured_feature", "plant", "wild_crop", "cobblemon_berry_patches.json"), 'w') as f:
    json.dump(cobblemon_berry_patches, f, indent=4)
    