
# StickyAvatar
[![](https://jitpack.io/v/samiazar/StickyAvatar.svg)](https://jitpack.io/#samiazar/StickyAvatar)

There is very common design in android chat aplications to show avatar of user beside message's bubbles, And also there is an issue about showing avatar while we are scrolling the list. If avatar doesn't move up by scroll so we may see empty space in page. This library helps you to implement SticktAvatar behaviour with RecyclerView.
Thanks to [StickyHeader](https://github.com/shuhart/StickyHeader) library because the main idea of our library based on that.

<img src="/demo/demo.gif" alt="Demo" width="300px" />


## Usage
**Step 1.** Add it in your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

**Step 2.**  Add the dependency

```
dependencies {
	implementation 'com.github.samiazar:StickyAvatar:0.1.0'
}
```
An adapter that implements [StickyAvatarInterface](https://github.com/samiazar/StickyAvatar/blob/master/library/src/main/java/com/saimazar/library/StickAvatarInterface.kt) is necessary for the StickyAvatarItemDecorator that is used to create and bind sticky headers:

```kotlin
override fun getLastMessagePositionInSequenceForItem(itemPosition: Int): Int {  
     // return position of last item in sequence for given `itemPosition`
     // If `itemPosition` is not in sequence or must not show sticky avatar (for example date message)
     // you can return RecyclerView.NO_POSITION for skip that
}  
  
override fun getAvatarLayout(avatarPosition: Int): Int {  
      // return the layout address for avatar (R.layout.some_view_that_show_avatar)
      // You can make decision based on 'avatarPosition` that avatar must be in left or right
}  
  
override fun bindAvatarData(avatarView: View, headerPosition: Int) {  
      // show avatar for avatarView, avatarView is the same object that you returned 
      // in `getAvatarLayout` file
}  
  
override fun isSequenceBreaker(itemPosition: Int): Boolean {  
     // Sequence breaker means the item that breaks some sequence, for example message of 
     // another user. If the `itemPosition` is sequence breaker the previous item avatar 
     // start goes out of page
}
```

Then, attach it to the RecyclerView:

```kotlin
val decorator = StickyAvatarItemDecorator(adapter, margin) //the second argument must be the margin between items in dp
decorator.attachToRecyclerView(recyclerView);
```

# License

```
Copyright 2019 MohamadAmin SamiAzar.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
