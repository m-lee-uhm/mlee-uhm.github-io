---
layout: project
type: project
image: img/machine-learning-ICS235/ml-project-cover.png
title: "Finding Cancer Using Machine Learning"
date: 2024-09-05
published: true
labels:
  - Machine Learning
  - Python
  - Pandas
  - sk-learn
  - mathplot
  - numpy
summary: "A homework assignment I had for ICS235."
---

This project was an assignment in ICS235 where I used machine learning to separate and cluster data in an attempt to figure out different cancer types by looking at the gene expression level of a tissue. 

The goal of the assignment was to graph and group the data by their label:
<img width="100%" height ="100%" src="/img/machine-learning-ICS235/machine-learning-ICS235-result.png">

I achieved this result by training a regression neural network with a two-neuron hidden layer in an unsupervised manner. Here's a diagram of what the neural network looks like:
<img width="100%" height ="100%" src="/img/machine-learning-ICS235/autoencoder.png">

From this project, I learned how to build a simple neural network. This neural network was quite simple as the only hidden layer of the network only had two neurons, but I learned how to build larger and more complex neural networks. This project required me to learn how to efficiently read documentation. 

I was the person responsible for this whole project because it was a homework assignment. I did get help from my professor when I was unsure on what to do, but most of the work for this project came from reading documentation and watching Youtube videos when I was confused by what I was doing.

Heres a snippet of the code I used:
```
# Calculate the values based on the function h(x) = f(Wx+b)
# f(x) returns x since the activation function was "identity"
hidden_representation = (np.matmul(X_scaled_tcga, tcga_mlp.coefs_[0])
                        + tcga_mlp.intercepts_[0])

# Seperate data into two parts
hidden_representation_X = hidden_representation[:,0]
hidden_representation_y = hidden_representation[:,1]
# Create plot
fig, ax = plt.subplots()
for label in np.unique(y):
    idx = np.where(y == label)
    ax.scatter(hidden_representation_X[idx],
               hidden_representation_y[idx],
               c=color_dict[label], label=label)
# Add legend and axis-labels
ax.legend()
plt.xlabel("Principal Component One")
plt.ylabel("Principal Component Two")

```

---

---

<img class="img-fluid" src="../img/cotton/cotton-header.png">

Cotton is a horror-style text-based adventure game I developed using the functions and macros built from The Wizard's Game in [Conrad Barski's Land of Lisp](http://landoflisp.com/). Slightly more interesting and convoluted! (It is not that scary.)

To give you a flavor of the game, here is an excerpt from one run:

<hr>

<pre>
You open your eyes, and you are greeted by an unfamiliar ceiling.
Startled, you get to your feet and quickly scan your surroundings. It's
dark except for the stream of light coming from a crack on the only boarded
window in the room. You try to peek through the crack, but you cannot see
anything. You wonder where you are and who could have possibly brought you here.

<--------------------help------------------------>
Enter quit or one of the following commands -
Weld light look walk pickup inventory help h ?
<------------------------------------------------>

look
The room is a picture of decay with only a faded number identifying it as room-4. The bed you were
 lying on is stained with what looks like dried blood. Could it be your blood? No - it is not. The
 only way out of the room aside from the door to the corridor is a window that is boarded shut. It
 looks like it has been like that for decades. There is a door going west from here. You see a candle
 on the floor. You see a match on the floor.

pickup candle
- you are now carrying the candle -

pickup match
- you are now carrying the match -

light match candle

The candle is now lit. It illuminates everything in the room.

walk west
The corridor is lit with the candle. It is so long that you cannot see to the end. You notice that
 there are words written on the wall. There is a door going east from here. There is a way going north
 from here. There is a door going south from here.
</pre>

<hr>

Source: <a href="https://github.com/jogarces/ics-313-text-game"><i class="large github icon "></i>jogarces/ics-313-text-game</a>

