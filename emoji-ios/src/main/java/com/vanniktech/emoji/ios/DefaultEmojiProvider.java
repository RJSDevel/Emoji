package com.vanniktech.emoji.ios;

import android.support.annotation.NonNull;

import com.vanniktech.emoji.EmojiProvider;
import com.vanniktech.emoji.emoji.EmojiCategory;
import com.vanniktech.emoji.ios.category.ActivityCategory;
import com.vanniktech.emoji.ios.category.FlagsCategory;
import com.vanniktech.emoji.ios.category.FoodCategory;
import com.vanniktech.emoji.ios.category.NatureCategory;
import com.vanniktech.emoji.ios.category.ObjectsCategory;
import com.vanniktech.emoji.ios.category.PeopleCategory;
import com.vanniktech.emoji.ios.category.SymbolsCategory;
import com.vanniktech.emoji.ios.category.TravelCategory;

public final class DefaultEmojiProvider implements EmojiProvider {
    @Override @NonNull
    public EmojiCategory[] getCategories() {
        return new EmojiCategory[] {
                new PeopleCategory(),
                new SymbolsCategory(),
                new FoodCategory(),
                new TravelCategory(),
                new NatureCategory(),
                new ActivityCategory(),
                new ObjectsCategory(),
                new FlagsCategory()
                // new StickersPackTwoCategory(),
                // new StickersPackThreeCategory()
        };
    }
}