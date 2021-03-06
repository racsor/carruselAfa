package org.racsor.carrusel;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {


    /**
     * Define the number of items visible when the carousel is first shown.
     */
//    private static final float INITIAL_ITEMS_COUNT = 3.5F;
    private static final float INITIAL_ITEMS_COUNT = 1F;

    /**
     * Carousel container layout
     */
    private LinearLayout mCarouselContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set title
        setTitle(R.string.KPetShop);

        // Set content layout
        setContentView(R.layout.activity_main);

        // Get reference to carousel container
        mCarouselContainer = (LinearLayout) findViewById(R.id.carousel);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Compute the width of a carousel item based on the screen width and number of initial items.
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int imageWidth = (int) (displayMetrics.widthPixels / INITIAL_ITEMS_COUNT);
        final int imageHeight = (int) (displayMetrics.heightPixels / INITIAL_ITEMS_COUNT);

        // Get the array of puppy resources
        final TypedArray puppyResourcesTypedArray = getResources().obtainTypedArray(R.array.puppies_array);

        // Populate the carousel with items
        ImageView imageItem;
        for (int i = 0 ; i < puppyResourcesTypedArray.length() ; ++i) {
            // Create new ImageView
            imageItem = new ImageView(this);

            // Set the shadow background
            imageItem.setBackgroundResource(R.drawable.shadow);

            // Set the image view resource
            imageItem.setImageResource(puppyResourcesTypedArray.getResourceId(i, -1));

            // Set the size of the image view to the previously computed value
            imageItem.setLayoutParams(new LinearLayout.LayoutParams(imageWidth, imageHeight));

            /// Add image view to the carousel container
            mCarouselContainer.addView(imageItem);
        }
    }

}
