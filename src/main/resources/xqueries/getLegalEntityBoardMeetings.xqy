let $legalEntityName := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))

let $legalEntityBoardMeeting := /legalEntity[@source=$source][@fid=$legalEntityName]/summary/boardMeetings
let $periodType:=for $x in $legalEntityBoardMeeting/meeting
return <meetingType>{$x/periodType/text()}</meetingType>

let $periodValue:=for $x in $legalEntityBoardMeeting/meeting
return <meetingValue>{$x/value/text()}</meetingValue>

return <BoardMeetings>
    <summary>{$legalEntityBoardMeeting/summaries/summary/text()}</summary>

    <type>{$periodType}</type>
    <value>{$periodValue}</value>
</BoardMeetings>