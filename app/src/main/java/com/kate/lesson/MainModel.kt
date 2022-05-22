package com.kate.lesson

import android.content.Context

/**
 * Created by Kate on 2022/5/22.
 */
class MainModel {

  fun affirmationList(context: Context): List<Affirmation> {
    return listOf(
      Affirmation(
        title = context.getString(R.string.affirmation1),
        imageResourceId = R.drawable.image1
      ),
      Affirmation(
        title = context.getString(R.string.affirmation2),
        imageResourceId = R.drawable.image2
      ),
      Affirmation(
        title = context.getString(R.string.affirmation3),
        imageResourceId = R.drawable.image3
      ),
      Affirmation(
        title = context.getString(R.string.affirmation4),
        imageResourceId = R.drawable.image4
      ),
      Affirmation(
        title = context.getString(R.string.affirmation5),
        imageResourceId = R.drawable.image5
      ),
      Affirmation(
        title = context.getString(R.string.affirmation6),
        imageResourceId = R.drawable.image6
      ),
      Affirmation(
        title = context.getString(R.string.affirmation7),
        imageResourceId = R.drawable.image7
      ),
      Affirmation(
        title = context.getString(R.string.affirmation8),
        imageResourceId = R.drawable.image8
      ),
      Affirmation(
        title = context.getString(R.string.affirmation9),
        imageResourceId = R.drawable.image9
      ),
      Affirmation(
        title = context.getString(R.string.affirmation10),
        imageResourceId = R.drawable.image10
      ),
    )
  }

}