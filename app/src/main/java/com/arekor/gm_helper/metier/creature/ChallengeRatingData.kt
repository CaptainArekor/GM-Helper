package com.arekor.gm_helper.metier.creature

import com.arekor.gm_helper.metier.creature.model.ChallengeRating

class ChallengeRatingData {
    companion object{
        fun getChallengeRating(): MutableList<ChallengeRating>{
            var ratings : MutableList<ChallengeRating> = mutableListOf()
            ratings.add(ChallengeRating(0.0,3))
            ratings.add(ChallengeRating(0.5,5))
            ratings.add(ChallengeRating(1.0,10))
            ratings.add(ChallengeRating(2.0,20))
            ratings.add(ChallengeRating(3.0,40))
            ratings.add(ChallengeRating(4.0,70))
            ratings.add(ChallengeRating(5.0,100))
            ratings.add(ChallengeRating(6.0,150))
            ratings.add(ChallengeRating(7.0,200))
            ratings.add(ChallengeRating(8.0,250))
            ratings.add(ChallengeRating(9.0,320))
            ratings.add(ChallengeRating(10.0,400))
            ratings.add(ChallengeRating(11.0,500))
            ratings.add(ChallengeRating(12.0,600))
            ratings.add(ChallengeRating(13.0,700))
            ratings.add(ChallengeRating(14.0,850))
            ratings.add(ChallengeRating(15.0,1000))
            ratings.add(ChallengeRating(16.0,1200))
            ratings.add(ChallengeRating(17.0,1400))
            ratings.add(ChallengeRating(18.0,1600))
            ratings.add(ChallengeRating(19.0,1800))
            ratings.add(ChallengeRating(20.0,2000))
            return ratings
        }
    }
}