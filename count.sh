#!/bin/sh
USERS=$(git log --format='%aN' | sort -h | uniq | awk -F'\n' '{print $0}END{print NR}')
USERS_LENGTH=$(printf "%s" "$USERS" | tail -n 1)
USERS=$(printf "%s" "$USERS" | head -n -1)
for index in $(seq 1 $USERS_LENGTH); do
	USER=$(printf "%s" "$USERS" | awk -F'\n' "NR==$index{printf \"%s\", \$0}")
	git log --all --numstat --author="$USER" --pretty=format:"%%" | sed 's/\([0-9-]*\)\s*\([0-9-]*\).*/\1 \2/' | awk 'BEGIN{total_delete=0; total_write=0} {if($0 != " " && $0 != "- -"){total_write+=int($1);total_delete+=int($2)} } END{printf "%5d +++ | %5d ---", total_write, total_delete}'
	echo " -> $USER"
done | sort -hr
