let $legalEntityName := xs:string(xdmp:get-request-field("fid"))
let $source := xs:string(xdmp:get-request-field("source"))

let $legalEntityBoardMeeting := /legalEntity[@source=$source][@fid=$legalEntityName]/summary/boardMeetings
return <BoardMeetings>
    <summary>{$legalEntityBoardMeeting/summaries/summary/text()}</summary>
    <type>{$legalEntityBoardMeeting/meeting/periodType/text()}</type>
    <value>{$legalEntityBoardMeeting/meeting/value/text()}</value>
</BoardMeetings>