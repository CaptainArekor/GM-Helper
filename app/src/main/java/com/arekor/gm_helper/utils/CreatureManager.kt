package com.arekor.gm_helper.utils

import com.arekor.gm_helper.data.model.Creature

class CreatureManager {
    companion object {
        fun createNewCreature(): Creature {
            return Creature(
                null,
                "",
                1.0,
                null,
                "Medium",
                "Humanoid",
                "Unaligned",
                10,
                10,
                10,
                10,
                10,
                10,
                10,
                10,
                1,
                "",
                ""
            )

        }
    }
}