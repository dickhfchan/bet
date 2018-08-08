# Bet Service
Bet Service is one of the micro-services of Mountbet.com which provides BetUpdate streaming api, order subscription.

BetUpdate streaming api: 
  - Bet updates messages are sent from server to client immediately after convert to dto on each bet change.

Order subscription:
  - subscribes to orders changes events and update bet data on cassandra <br> Example: order matched, order cancelled, price changed
