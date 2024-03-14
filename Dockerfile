FROM ubuntu:latest
LABEL authors="pvl"

ENTRYPOINT ["top", "-b"]