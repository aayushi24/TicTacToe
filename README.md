Assumptions:

1. For Simplicity, game will not maintaining profiles for a user. Any one can login and start a new session, and no records will be maintained once the game is over.
2. First move will always be a 'x', whether its by computer or by player.
3. This game currently supports single player and no observers.
4. Users cannot undo their moves.

####Calculating the best move:
The best move is calculated by using Minimax Algorithm. 

- Reference : https://towardsdatascience.com/tic-tac-toe-creating-unbeatable-ai-with-minimax-algorithm-8af9e52c1e7d


#### TODOs
- Sugeestions for players
- Maintaining some history or data for player in form of profiles.
- Currently since computer uses Minimax algo to get the best move, it would be kind of impossible for users to win the game. Difficulty levels can be set as well.
- Currently, player initialization is hard coded to one human player and one computer player, that can modifies to taken as input from user.
