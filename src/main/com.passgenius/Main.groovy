package com.passgenius

static void main(String[] args) {

  def newVersion = VersionUpdater.generateVersion()
  System.out.println(newVersion)
}