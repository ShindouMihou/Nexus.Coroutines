![Splashscreen](https://github.com/ShindouMihou/Nexus/assets/69381903/e2e2118b-07c4-4c49-9322-0507dc1ebf5c)

#

<div align="center"><i>Coroutines for  Nexus</i></div>
<br/>

Nexus Coroutines is an addon for Nexus that integrates Kotlin coroutines to the framework. It adds new interfaces and 
extension functions that simply and properly enables you to use coroutines in the different features of the framework.

This adds coroutines only to the base framework, and not any other addons. Although the underlying engine of Nexus 
should be using coroutines once this is set-up.

## Overview
Right before you start to use Nexus, to have the add-on configure the relevant configurations, you need to add this 
line at the start, way before anything Nexus-related happens:
```kotlin
Nexus.useCoroutines()
```

Once you've done that, you need to use the `Async` interfaces and extensions. For example, instead of `NexusHandler`, 
you should use `AsyncNexusHandler`. 

Here's an overview list of all the `Async` interfaces:
- `AsyncNexusHandler`: replacement for `NexusHandler`
- `AsyncNexusAfterware`: replacement for `NexusAfterware`
- `AsyncRouteable`: replacement for `SubcommandRouter`'s `Routeable`
- `AsyncNexusExpressRequest`: replacement for `NexusExpressRequest`

You are also free to use the `coroutine` extension function provided in this, if you'd like.