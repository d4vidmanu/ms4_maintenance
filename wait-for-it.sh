#!/usr/bin/env bash
# wait-for-it.sh - Esperar hasta que un servicio en un host/puerto esté disponible

set -e

host="$1"
shift
port="$1"
shift
cmd="$@"

while ! nc -z "$host" "$port"; do
  echo "Esperando a que $host:$port esté disponible..."
  sleep 2
done

exec $cmd
