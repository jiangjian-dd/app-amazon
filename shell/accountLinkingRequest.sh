#!/bin/bash

#import env
. env.sh

#define request

echo "Request is: " 
cat accountLinkingRequest.txt

echo -e "\nResponse is: " 
curl   -X POST -d @accountLinkingRequest.txt http://localhost:8080/accountLinking \
 -H "Content-Type:application/json" \
 -H "Authorization: DTA1-HMAC-SHA256 SignedHeaders=content-type;x-amz-date, Credential=KEYID/20160115, Signature=0c630311e72fce61782e73908eb34a0fcf22edef05e16b310d236efad9314762" \
 -H 'x-amz-date:20160115T095007Z'

echo -e "\n\n"
