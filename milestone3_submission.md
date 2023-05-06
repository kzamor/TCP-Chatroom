<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 85c2314341523137715ca697955455f8e464f2f1
<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone3</td></tr>
<tr><td> <em>Student: </em> Kelvin Zamor (kpz2)</td></tr>
<tr><td> <em>Generated: </em> 5/6/2023 11:32:13 AM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone3/grade/kpz2" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/233792875-0c571ef2-18e7-48ad-bb83-3fd899ab0fbd.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing code for username, host, and port<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <p>&nbsp;When the user clicks the &quot;Connect&quot; button, the code gets the username, host,<br>and port that the user entered, and uses these values to connect to<br>the chat server.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Chatroom view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/233793106-622559a3-da9d-4b06-9581-31865be010fe.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing a list of users in the room, the chat message area with<br>chat history, and the create message area with the send button<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/233793482-5406c0da-0406-4c53-aecc-cd89bfabe920.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing the code that lets the enter key send the message<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Chat Activities </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the result of the following commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/233794808-3fb68550-b00d-4130-a08a-4dc634f20682.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>shows /flip and /roll<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code snippets for each command</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/233795009-f6a56280-7003-448f-b8d3-45b6aba819f8.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing server side code fot /flip and /roll. as well as comments<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code flow of each command</td></tr>
<tr><td> <em>Response:</em> <p>/roll works because if the message the user enters contains a &quot;d&quot;, for<br>example, &quot;2d6&quot;, it takes the first number and sets it to numDice and<br>it takes the second number and sets it to maxNum.It then subtracts the<br>min from the max for the upper limit, then adds the min to<br>the result. If the message doesn&#39;t contain a &quot;d&quot;, the code then picks<br>a random number from 1 to whatever number the user entered. /flip works<br>by choosing a random number between 1 and 0. If the number is<br>0 then message = heads and if the number is 1, then message<br>= tails. Both /flip and /roll commands include &quot;<em>b&quot; and &quot;b</em>&quot; which formats<br>and displays the text in bold.&nbsp;The client-server-client flow is where a client program<br>sends a message to a server program over a network connection, the server<br>receives the message, processes it, and then sends a response back to the<br>client.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Custom Text </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of examples</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/233795653-0c0efea3-6691-4ad0-be10-b1ca2df1320b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>bold<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/233795727-6bd20ba4-f057-462e-bdbb-e13589892dde.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>italics<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/233795780-30cef09b-3548-4bfb-a464-fafa8a6e2114.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>underline<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/233795954-f30dd820-ce75-40fc-8664-a786d76525d9.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>color and a combination of everything together<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how you got the UI side to render the text accordingly</td></tr>
<tr><td> <em>Response:</em> <p>I changed JEditorPane in ChatPanel.java to type &quot;html&quot; instead of type &quot;plain&quot;.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Whisper </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing a demo of whisper commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/233796211-1d612a7f-15b2-4cc4-a23d-d15e10181f0d.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing kel sending a private message to frank<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the server-side code snippets of how this feature works</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/233796357-0fa95a66-7856-4731-9238-c2557bf856f3.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing how the message is processed to find the target of the whisper<br>and how the sender and the whisper target are the only ones to<br>get the message<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>It checks if a message is a private message by splitting the message<br>string into two parts at the first space. If the first part starts<br>with &quot;@&quot;, the message is private, so it takes the receiver&#39;s username and<br>the message text from the two parts. Then, it searches for a client<br>with the same username as the receiver out of all the clients. If<br>it finds the receiver, it sends a private message to both the sender<br>and the receiver. The message starts with &quot;To&quot; for the receiver and &quot;From&quot;<br>for the sender.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 6: </em> Mute/Unmute </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots demoing this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/236601985-c4be7461-76ff-4910-b79b-a85aa675b312.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>this shows a muter being muted and unmuted int the room<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshots of the code snippets that achieve this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/127684882/236602073-f7933409-d1d9-46d1-91ef-77f169e90936.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>code shows code for mute and unmute commands<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>The code allows users to mute and unmute other users. For the MUTE<br>command, the code adds the muted user to a list and sends a<br>message saying that they have been muted. If the user is not found,<br>a message saying this is sent to the client. For the UNMUTE command,<br>the code removes the user from the muted list and sends a message<br>saying that they have been unmuted. If the user is not found, nothing<br>happens.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 7: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull request from milestone3 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/kzamor/IT114-008/pull/13">https://github.com/kzamor/IT114-008/pull/13</a> </td></tr>
</table></td></tr>
<<<<<<< HEAD
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone3/grade/kpz2" target="_blank">Grading</a></td></tr></table>
>>>>>>> c58e61317e8422b2dd0bd430b22cf4c436328ac9
=======
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone3/grade/kpz2" target="_blank">Grading</a></td></tr></table>
>>>>>>> 85c2314341523137715ca697955455f8e464f2f1
