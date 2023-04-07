<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> Kelvin Zamor (kpz2)</td></tr>
<tr><td> <em>Generated: </em> 4/7/2023 5:43:26 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone-2/grade/kpz2" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/230232934-6e8e1cfe-cc98-40f5-a112-b07aac8e4ff0.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>payload code with comments explaining the methods<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/230233148-ffc0248c-d8cc-4d02-ac90-c0c942ab5ed1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>screenshot of terminal showing Wrapped messages in payload so extra data can be<br>sent/received<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/230676337-fcc1e0cb-e4c3-4c78-9430-7b327081912e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>code for /roll and /flip<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <p>/roll works because if the message the user enters contains a &quot;d&quot;, for<br>example, &quot;2d6&quot;, it takes the first number and sets it to numOfDice and<br>it takes the second number and sets it to max. If the message<br>doesn&#39;t contain a &quot;d&quot;, the code then picks a random number from 1<br>to whatever number the user entered. /flip works by choosing a random number<br>between 1 and 0. If the number is 0 then message = heads<br>and if the number is 1, then message = tails.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling via markdown or special characters</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/230680941-9e737a78-5492-4ee9-8a66-4a3aaec289c4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing how bold, italics, color, and underline are all processed<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/230681236-7c09292d-9c23-4b8c-bebc-6bf125095f55.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing how bold, italics, color, and underline are displayed in the terminal. including<br>a combination of all options<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <p>The way I got each style applied is I used the replace method<br>to replace the user input with the correct HTML tag. For example, <em>b<br>and b</em> turn into &lt;b&gt; and &lt;/b&gt;. I did the same thing for<br>color making it so that #r and r# turn into &lt;font&gt; and &lt;/font&gt;.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/kzamor/IT114-008/pull/9">https://github.com/kzamor/IT114-008/pull/9</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone-2/grade/kpz2" target="_blank">Grading</a></td></tr></table>