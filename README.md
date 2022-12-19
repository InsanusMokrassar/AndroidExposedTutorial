# Android Exposed Tutorial

This repo is the tutorial repo for the [HabraHabr post](https://habr.com/ru/post/706220/) about connecting of
[Exposed](https://github.com/JetBrains/Exposed) library to Android project.

## Structure

* `app` - sample application with demonstration of database and table work
* `gradle` - gradle-oriented things like `libs.versions.toml` with dependencies and gradle wrapper info
* `lib` - the main part with `DataTable` as sample table in JVM and `main` source set as android ready-to-use
  library with exposed setup
