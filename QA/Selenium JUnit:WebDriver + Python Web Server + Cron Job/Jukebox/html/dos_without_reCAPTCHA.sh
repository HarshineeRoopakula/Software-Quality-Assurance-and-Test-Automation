#!/usr/bin/env zsh

random()
{
   start_time=$1
   end_time=$2
   DIFF=$(($end_time-$start_time+1))
   echo $(($(($RANDOM%$DIFF))+$start_time))
}
start_time=1
end_time=25
RANDOM=$$
cat /Users/hemanthharshinee/html/info.txt | while read song cc_number
do
   sleep_time=`random $start_time $end_time`
   sleep $sleep_time
echo "${song} ${cc_number}"
    wget "http://127.0.0.1:8000/cgi-bin/without_reCAPTCHA.py?song=${song}&cc_number=${cc_number}"
done
