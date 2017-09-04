package com.vanniktech.emoji.emoji;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public final class Emoji implements Serializable {
  private static final long serialVersionUID = 3L;

  @NonNull private final String unicode;
  @DrawableRes private final int resource;
  @NonNull private final List<Emoji> variants;
  @Nullable private Emoji base;
  private boolean isStickers = false;

  public Emoji(@NonNull final int[] codePoints, @DrawableRes final int resource) {
    this(codePoints, resource, new Emoji[0]);
  }

  public Emoji(final int codePoint, @DrawableRes final int resource) {
    this(codePoint, resource, new Emoji[0]);
  }

  public Emoji(final int codePoint, @DrawableRes final int resource, boolean isStickers) {
    this(codePoint, resource, new Emoji[0]);
    this.isStickers = isStickers;
  }

  public Emoji(final int codePoint, @DrawableRes final int resource, final Emoji... variants) {
    this(new int[]{codePoint}, resource, variants);
  }

  public Emoji(@NonNull final int[] codePoints, @DrawableRes final int resource, final Emoji... variants) {
    this.unicode = new String(codePoints, 0, codePoints.length);
    this.resource = resource;
    this.variants = asList(variants);

    for (final Emoji variant : variants) {
      variant.base = this;
    }
  }

  @NonNull public String getUnicode() {
    return unicode;
  }

  @DrawableRes public int getResource() {
    return resource;
  }

  @NonNull public List<Emoji> getVariants() {
    return new ArrayList<>(variants);
  }

  @NonNull public Emoji getBase() {
    Emoji result = this;

    while (result.base != null) {
      result = result.base;
    }

    return result;
  }

  public boolean isStickers() {
    return isStickers;
  }

  public int getLength() {
    return unicode.length();
  }

  public boolean hasVariants() {
    return !variants.isEmpty();
  }

  @Override public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Emoji emoji = (Emoji) o;

    return resource == emoji.resource
            && unicode.equals(emoji.unicode)
            && variants.equals(emoji.variants);
  }

  @Override public int hashCode() {
    int result = unicode.hashCode();
    result = 31 * result + resource;
    result = 31 * result + variants.hashCode();
    return result;
  }
}
