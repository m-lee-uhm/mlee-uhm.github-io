---
layout: project
style: project
image: img/machine-learning-ICS235/ml-project-cover.png
title: "Finding Cancer Using Machine Learning"
date: 2024-09-05
published: true
label:
  - Machine Learning
  - Python
  - Pandas
  - sk-learn
  - mathplot
  - numpy
summary: "A homework assignment I had for ICS235"
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

