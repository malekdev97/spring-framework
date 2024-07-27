FROM debian:latest

ARG TOKEN=not-set

RUN apt-get update && apt-get install -y curl libgtk-dotnet3.0-cil

ENV RUNNER_ALLOW_RUNASROOT=1

