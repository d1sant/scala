#!/bin/sh
exec scala "$0" "$@"
!#

println(formatArgs(args))

def formatArgs(args: Array[String]) = args.mkString("\n")
